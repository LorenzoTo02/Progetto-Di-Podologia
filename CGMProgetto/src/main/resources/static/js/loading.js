window.addEventListener("load", function() {

    const loadingScreen = document.querySelector('#loading-screen');
    const loader = document.querySelector("#load");
    
    setTimeout(function() {
        // loadingScreen.style.display = 'none';
        loadingScreen.setAttribute("class", "animate__animated animate__fadeOut");
        loader.setAttribute("class","animate__animated animate__fadeOut");
        // loader.setAttribute("hidden","");

        setTimeout(function(){
            loadingScreen.setAttribute("hidden","");
            load.setAttribute("hidden","");
        }, 200)

    }, 90);

});