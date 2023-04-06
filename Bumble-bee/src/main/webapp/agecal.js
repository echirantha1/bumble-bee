function calculateAge() {

    var nic = document.getElementById("txtNic").value;

    if (nic.length == 10) {

        var year = nic.substring(0, 2);

        var fullYear = '19' + year;

        var age = new Date().getFullYear() - parseInt(fullYear);

        if (age >= 18) {

        } else {
            alert("You must be over 18");
            document.getElementById("txtNic").value = "";
        }
    } else if (nic.length == 12) {

        var year = nic.substring(0, 4);

        var age = new Date().getFullYear() - parseInt(year);

        if (age < 18) {
            alert("You must be over 18");
            document.getElementById("txtNic").value = "";
        }
    } else {
        alert("Enter valid NIC");
        document.getElementById("txtNic").value = "";
    }
}