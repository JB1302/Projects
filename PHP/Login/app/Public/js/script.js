
function validarFormularioLogin() {
    const nombre = document.getElementById('nombre').value.trim();
    const password = document.getElementById('password').value.trim();
    if (nombre === "" || password === "") {
        alert("Campos de usuario y clave son requeridos.");
        return false;
    }
    return true;
}

document.addEventListener("DOMContentLoaded", () => {
    const taskList = document.getElementById("task-list");
    const taskInput = document.getElementById("task-input");
    const addTaskBtn = document.getElementById("add-task");

    function validarFormulario() {
        const input = document.getElementById('task-input').value.trim();
        if (input === "") {
            alert("Por favor, escribe una tarea antes de agregarla.");
            return false;
        }
        return true;
    }

})