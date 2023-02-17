const cardData = [
    {
        "title": "CPU",
        "id": "cpu",
        "subtitle": "Core-Processing-Unit",
        "text": "Die CPU ist das Herzstück eines Computers. Sie ist für die Verarbeitung von Daten zuständig. Die CPU ist in der Regel in einem Prozessor integriert.",
        "image": "https://user-images.githubusercontent.com/28064149/213037782-95306083-f304-495d-ba73-e74867a7a8df.png",
    },
    {
        "title": "Graphics Card",
        "id": "gpu",
        "subtitle": "Produces viewable images",
        "text": "The graphics card is a specialized electronic circuit designed to rapidly manipulate and alter memory to accelerate the creation of images in a frame buffer intended for output to a display.",
        "image": "https://user-images.githubusercontent.com/28064149/213037782-95306083-f304-495d-ba73-e74867a7a8df.png",
    },
    {
        "title": "Mainboard",
        "id": "mainboard",
        "subtitle": "Motherboard",
        "text": "The mainboard is the main printed circuit board (PCB) in general-purpose computers and other expandable systems. It holds and allows communication between many of the crucial electronic components of a system, such as the central processing unit (CPU) and memory.",
        "image": "https://user-images.githubusercontent.com/28064149/213037782-95306083-f304-495d-ba73-e74867a7a8df.png",
    },
];


document.addEventListener("DOMContentLoaded", function() {
    const cards = document.createElement("grid-container");
    cards.classList.add("grid-container");
    
    for (let i = 0; i < cardData.length; i++) {
        const card = document.createElement("div");
        card.classList.add("card");
        card.innerHTML = `
            <div class="card-item">
                <h2  id="grid-item-title" class="grid-item-title">${cardData[i].title}</h2>
                <h3 id="grid-item-text" class="grid-item-text">${cardData[i].subtitle}</h3>
                <p id="grid-item-hover-text" class="grid-item-hover-text">${cardData[i].text}</p>
            </div>
        `;
        card.style.backgroundImage = `url(${cardData[i].image})`;
        card.style.backgroundSize = "cover";
        card.style.backgroundPosition = "center";
        
        cards.appendChild(card);
    }

    document.body.appendChild(cards);
    
});

document.addEventListener('mouseover', function(event) {
    //check wich item is hovered
    const hovered = document.getElementById(event.target.id);
    //get all id's from cardData
    const cardDataIds = cardData.map(card => card.id);
    document.getElementById(event.target.id).style.display = "none";
    document.getElementById(event.target.id).style.display = "none";
    console.log("hover");
    if (cardDataIds.includes(event.target.id)) {
        
    }
});
