function muestraImagen(input) {
    //Si hay un archivo
    if (input.files && input.files[0]) {
        //Lector de archivos para leerlos
        var lector = new FileReader();
        //cuando se cargue el archivo
        lector.onload = function (e) {
            //Poner la informacion leida como el SRC de la etiqueta
            $('#blah').attr('src', e.target.result)
                    .height(200);
        };

        lector.readAsDataURL(input.files[0]);
    }
}

document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.btn-danger[data-bs-toggle="modal"]').forEach(function (btn) {
        btn.addEventListener('click', function () {
            document.getElementById('modalId').value = btn.getAttribute('data-bs-id');
            document.getElementById('modalDescripcion').textContent = btn.getAttribute('data-bs-descripcion');
        });
    });
});
