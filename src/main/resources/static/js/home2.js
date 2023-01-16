
    window.onload = function() {
        const elements = document.getElementsByClassName('companyLinkedName');

        for (const element of elements) {
            element.addEventListener("click", e => {
                // window.location = "/company/companyInfo?id=" + e.target.innerHTML;

                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        alert(this.responseText);
                    }
                };
                xhttp.open("GET", "/company/companyInfo?id=" + e.target.innerHTML, true);
                xhttp.setRequestHeader("Content-type", "application/json");
                xhttp.send("Your JSON Data Here");

            })
        }
};


