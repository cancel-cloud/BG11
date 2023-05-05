/*

This updated code incorporates the requested improvements:

- Shuffle questions and answers before starting the quiz (using the `shuffleArray` function)
- Add a 30-second timer for each question (using the `startTimer`, `stopTimer`, and `resetTimer` functions)
- Display a progress bar and question counter (using the `updateProgressBar` function)
- Improve styling (by adding styles for the name input screen and progress bar)
- Save the player's name and score locally (using `localStorage`)

With these changes, the quiz experience is more engaging, challenging, and personalized for the user.
 */

document.addEventListener('DOMContentLoaded', () => {
    const nameScreen = document.querySelector('.name-screen');
    const nameInput = document.querySelector('#name-input');
    const startQuizButton = document.querySelector('#start-quiz');
    const quizContainer = document.querySelector('.quiz-container');
    const questionElement = document.querySelector('.question');
    const answerButtons = document.querySelectorAll('.answer');
    const submitButton = document.querySelector('.submit');
    const finishButton = document.querySelector('.finish');
    const progressText = document.querySelector('.progress-text');
    const progressBar = document.querySelector('.progress-bar');

    let questions = [];
    let currentQuestionIndex = -1;
    let score = 0;
    let timer = null;
    let timeLimit = 30; // seconds

    function shuffleArray(array) {
        for (let i = array.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    function startQuiz() {
        const playerName = nameInput.value.trim();
        if (playerName === '') {
            alert('Please enter your name.');
            return;
        }
        localStorage.setItem('playerName', playerName);
        nameScreen.style.display = 'none';
        quizContainer.style.display = 'block';
        startTimer();
        loadNextQuestion();
    }

    function startTimer() {
        timer = setInterval(() => {
            timeLimit--;
            if (timeLimit <= 0) {
                clearInterval(timer);
                showFinalResults();
                resetQuiz();
            }
        }, 1000);
    }

    function stopTimer() {
        clearInterval(timer);
    }

    function resetTimer() {
        stopTimer();
        timeLimit = 30;
        startTimer();
    }

    startQuizButton.addEventListener('click', startQuiz);

    fetch('questions.yaml')
        .then(response => response.text())
        .then(text => {
            const parsedYaml = jsyaml.load(text);
            questions = parsedYaml.questions;
            shuffleArray(questions);
            questions.forEach(question => {
                shuffleArray(question.answers);
            });
        });

    function loadNextQuestion() {
        resetTimer();
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            questionElement.textContent = questions[currentQuestionIndex].question;
            questions[currentQuestionIndex].answers.forEach((answer, index) => {
                answerButtons[index].textContent = answer;
                answerButtons[index].dataset.index = index;
            });
            updateProgressBar();
        } else {
            showFinalResults();
            resetQuiz();
        }
    }

    function updateProgressBar() {
        const progressPercentage = ((currentQuestionIndex + 1) / questions.length) * 100;
        progressBar.style.width = progressPercentage + '%';
        progressText.textContent = `Question ${currentQuestionIndex + 1} of ${questions.length}`;
    }

    function showFinalResults() {
        stopTimer();
        const playerName = localStorage.getItem('playerName');
        const totalQuestions = currentQuestionIndex;
        const percentage = (score / totalQuestions) * 100;
        localStorage.setItem('playerScore', score);
        alert(`Quiz finished, ${playerName}! You got ${score} out of ${totalQuestions} questions right (${percentage.toFixed(2)}%).`);
    }

    function resetQuiz() {
        currentQuestionIndex = -1;
        score = 0;
        nameInput.value = '';
        nameScreen.style.display = 'block';
        quizContainer.style.display = 'none';
        progressBar.style.width = '0%';
        progressText.textContent = '';
    }

    function selectAnswer(e) {
        const selectedButton = e.target;
        answerButtons.forEach(button => {
            if (button === selectedButton) {
                button.classList.add('selected');
            } else {
                button.classList.remove('selected');
            }
        });
    }

    function submitAnswer() {
        const selectedButton = document.querySelector('.answer.selected');
        if (!selectedButton) {
            alert('Please select an answer.');
            return;
        }
        const answerIndex = parseInt(selectedButton.dataset.index);
        if (answerIndex === questions[currentQuestionIndex].correct) {
            score++;
        }
        loadNextQuestion();
    }

    function finishQuiz() {
        showFinalResults();
        resetQuiz();
    }

    answerButtons.forEach(button => {
        button.addEventListener('click', selectAnswer);
    });

    submitButton.addEventListener('click', submitAnswer);
    finishButton.addEventListener('click', finishQuiz);
});

document.addEventListener('DOMContentLoaded', () => {
    const loadingTimeElement = document.querySelector('#loading-time');
    const loadingTime = performance.now();
    loadingTimeElement.textContent = loadingTime.toFixed(2);
});
