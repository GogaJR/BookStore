<html>
<head>
</head>
<style>
    body{
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
.btns{
    padding: 20px;
}
</style>

<body>
<form method="post" action="/bookInfo/update" class="maindiv">

    <h3>Update Book</h3>


    <table align="center" cellpadding = "10" width="800">
        <input type="hidden" name="bookId" value="${book.id}">
        <input type="hidden" name="authorId" value="${book.author.id}">
        <!----- Title ---------------------------------------------------------->
        <tr>
            <td align="left">TITLE<br><input type="text" name="title" value="${book.title}" maxlength="50" required/>
            </td>



            <!----- Author ---------------------------------------------------------->
            <td align="left">AUTHOR FIRST NAME<br><input type="text" name="authorName" value="${book.author.name}" maxlength="50" required/>
            </td>

            <td align="left">AUTHOR LAST NAME<br><input type="text" name="authorSurname" value="${book.author.surname}" maxlength="50" required/>
            </td>

        </tr>

        <!----- Submit and Reset ------------------------------------------------->

    </table>
    <div class="btns">
        <button class="btnSubmit blue" name="button" value="ok">Update</button>
        <button class="btnSubmit blue" type="reset">Reset</button>
    </div>

</form>

</body>
</html>
