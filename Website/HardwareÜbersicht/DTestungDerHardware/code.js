const componentData = [
    {
        title: 'CPU',
        img: 'https://images.unsplash.com/photo-1625315714730-d0830cd368bd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1932&q=80',
        short: "Central Processing Unit",
        long: "The CPU is used for processing data. It's the heart of the computer."
    },
    {
        title: 'GPU',
        img: 'https://images.unsplash.com/photo-1591488320449-011701bb6704?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80',
        short: "Graphics Processing Unit",
        long: "The GPU is used for processing graphics and images. It computes the images displayed on screen."
    },
    {
        title: 'RAM',
        img: 'https://images.unsplash.com/photo-1542978709-19c95dc3bc7e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80',
        short: "Random Access Memory",
        long: "The RAM is used for storing data in a place, wich is fastly accessible. It is the short-term memory of the computer."
    },
    {
        title: 'Motherboard',
        img: 'https://images.unsplash.com/photo-1518770660439-4636190af475?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
        short: "Mainboard",
        long: "The motherboard is used for connecting all the components of the computer. It is the bones of the computer."
    },
    {
        title: 'Power Supply',
        img: 'https://images.unsplash.com/photo-1675893857450-783969c8922f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1074&q=80',
        short: "Power Supply Unit",
        long: "The power supply is used for providing power to the computer."
    },
    {
        title: 'SSD',
        img: 'https://images.unsplash.com/photo-1597138804456-e7dca7f59d54?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
        short: "Solid State Drive",
        long: "The SSD is used for storing large amount of data."
    },
    {
        title: 'Case',
        img: 'https://images.unsplash.com/photo-1587202372583-49330a15584d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80',
        short: "Computer Case",
        long: "The case is used for housing all the components of the computer."
    },
    {
        title: 'Keyboard',
        img: 'https://images.unsplash.com/photo-1602025882379-e01cf08baa51?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80',
        short: "Computer Keyboard",
        long: "The keyboard is used by a human to interact with the computer."
    },
    {
        title: 'Mouse',
        img: 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=765&q=80',
        short: "Computer Mouse",
        long: "The mouse is used by a human to interact with the computer."
    },
    {
        title: 'Monitor',
        img: 'https://images.unsplash.com/photo-1616711906333-23cf8b122a38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1035&q=80',
        short: "Computer Monitor",
        long: "The monitor is used for displaying images produced by the graphics card."
    }
];


// for each  in componentData, create a new component
componentData.forEach(item => {
    let container = document.getElementById('entries')


    const entriesDiv = document.getElementById("entries");
    const figureElem = document.createElement("figure");
    figureElem.id = "figure"
    figureElem.innerHTML = `<figcaption>
        <h2>${item.title}</h2> 
        <p>${item.long}</p>
        </figcaption>
        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/331810/sample70.jpg" alt="sample70" /> `;
    entriesDiv.appendChild(figureElem);
    
})