<#ftl encoding='UTF-8'>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;
            background-color: #f2f9ff;
            text-align: center;
        }
    .maindiv{
        padding: 20px;
    }
    
    button{
        background-color: #5b92e5;
        color: white;
        font-size: 17px;
    }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content */
        .modal-content {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        /* The Close Button */
        .close {
            color: #aaaaaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="maindiv">
        <h1>Book Title: ${book.title}</h1>
        <h2>Author: ${book.authorName} ${book.authorSurname}</h2>
            <a href="/bookInfo/update?bookId=${book.id}"><button type="submit" name="button" value="update">Update Book</button></a>
            <button id="myBtn" type="submit" name="button" value="delete">Delete Book</button>
        <!-- The Modal -->
        <div id="myModal" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>Are you sure you want to delete this book?</p>
                    <a href="/bookInfo/delete?bookId=${book.id}"><button type="submit" name="button" value="yes">Yes</button></a>
                    <button id="noBtn" type="submit" name="button" value="no">No</button>
            </div>

        </div>
    </div>

<script>
    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    var btnNo = document.getElementById("noBtn");

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    btnNo.onclick = function () {
        modal.style.display = "none";
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</body>
</html>
