window.addEventListener('DOMContentLoaded', async function(){

    console.log();

    $('#table_id').DataTable({
        ajax: './json/productos.json',
        columns : [
            {columns : id},
            {},
            {}
        ]
    });
});
