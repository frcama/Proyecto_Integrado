window.addEventListener('scroll',function(){
    let animacion = this.document.getElementById('animado');
    let posicionObj1 = animacion.getBoundingClientRect().top();
    console.log(posicionObj1);
    let tamañoDePantalla = window.innerHeight/3.5;

    if(posicionObj1 < tamañoDePantalla){
        animacion.style.animation = 'mover ls ease-out'
    }
})