document.addEventListener('DOMContentLoaded', () => {
    const questionElement = document.querySelector('.question');
    const answerButtons = document.querySelectorAll('.answer');
    const submitButton = document.querySelector('.submit');
    const finishButton = document.querySelector('.finish');

    let questions = [];
    let currentQuestionIndex = -1;
    let score = 0;

    // Fetch and parse the YAML file
    fetch('questions.yaml')
        .then(response => response.text())
        .then(text => {
            const parsedYaml = jsyaml.load(text);
            questions = parsedYaml.questions;
            loadNextQuestion();
        });

    function loadNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            questionElement.textContent = questions[currentQuestionIndex].question;
            questions[currentQuestionIndex].answers.forEach((answer, index) => {
                answerButtons[index].textContent = answer;
                answerButtons[index].dataset.index = index;
            });
        } else {
            showFinalResults();
            resetQuiz();
        }
    }

    function showFinalResults() {
        const totalQuestions = questions.length;
        const percentage = (score / totalQuestions) * 100;
        alert(`Quiz finished! You got ${score} out of ${totalQuestions + 1} questions right (${percentage.toFixed(2)}%).`);
    }

    function resetQuiz() {
        currentQuestionIndex = -1;
        score = 0;
        loadNextQuestion();
    }

    answerButtons.forEach(button => {
        button.addEventListener('click', () => {
            answerButtons.forEach(b => b.classList.remove('selected'));
            button.classList.add('selected');
        });
    });

    submitButton.addEventListener('click', () => {
        const selectedButton = document.querySelector('.answer.selected');
        if (selectedButton) {
            const selectedIndex = parseInt(selectedButton.dataset.index, 10);
            if (selectedIndex === questions[currentQuestionIndex].correct) {
                score++;
            }
            selectedButton.classList.remove('selected');
            loadNextQuestion();
        } else {
            alert('Please select an answer before submitting.');
        }
    });

    finishButton.addEventListener('click', () => {
        showFinalResults();
        resetQuiz();
    });
});
