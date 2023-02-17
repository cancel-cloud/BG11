const cardData = [
    {
        "title": "CPU",
        "subtitle": "Core-Processing-Unit",
        "text": "Die CPU ist das Herzstück eines Computers. Sie ist für die Verarbeitung von Daten zuständig. Die CPU ist in der Regel in einem Prozessor integriert.",
        "image": "../images/dataimage.jpg",
    },
    {
        "title": "Graphics Card",
        "subtitle": "Produces viewable images",
        "text": "The graphics card is a specialized electronic circuit designed to rapidly manipulate and alter memory to accelerate the creation of images in a frame buffer intended for output to a display.",
        "image": "../images/dataimage.jpg",
    },
];


document.addEventListener("DOMContentLoaded", function() {
    console.log("loadme() called");

    // print the first element of the cardData array to the console
    console.log(cardData[0]);
});