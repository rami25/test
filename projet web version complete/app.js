
function vider(){
    document.getElementById('annonce').style.display="none";
}

function verifMail(){
    var mail = document.getElementById('email').value;
    if(mail.indexOf('@')==-1 || mail.indexOf('.')==-1)
        window.alert('email invalide');
        

}

function verifNum(){
    var longueur = document.getElementById("num").value;
    if(longueur.length!=8)
        window.alert('numero invalid ');
}

function verifMot(){
    var mot = document.getElementById('mot').value;
    if(mot.length<8)
        window.alert("mot de passe invalid");
}

function confirmer(){
    alert("confirmer!!!");
}