anime({
    targets: '.row svg',
    translateY: 10,
    autoplay: true,
    loop: true,
    easing: 'easeInOutSine',
    direction: 'alternate'
});

anime({
    targets: '#zero',
    translateX: 10,
    autoplay: true,
    loop: true,
    easing: 'easeInOutSine',
    direction: 'alternate',
    scale: [{value: 1}, {value: 1.4}, {value: 1, delay: 250}],
    rotateY: {value: '+=180', delay: 200},
});

const error = document.querySelector(".error-500");
let i = 0, data = "", text = error.getAttribute("data-text");

let typing = setInterval(() => {
    if(i == text.length){
        clearInterval(typing);
    }else{
        data += text[i];
        document.querySelector(".error-500").setAttribute("data-text", data);
        i++;
    }
}, 100);