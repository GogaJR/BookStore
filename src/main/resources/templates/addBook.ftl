<html>
<head>
</head>
<style>
    body {
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
<form method="post" action="/addBook" class="maindiv">

    <h3>Add Book</h3>


    <table align="center" cellpadding = "10" width="800">

        <!----- Title ---------------------------------------------------------->
        <tr>
            <td align="left">TITLE<br><input type="text" name="title" maxlength="50" required/>
            </td>



            <!----- Author ---------------------------------------------------------->
            <td align="left">AUTHOR NAME<br><input type="text" name="authorName" maxlength="50" required/>
            </td>

            <td align="left">AUTHOR LAST NAME<br><input type="text" name="authorSurname" maxlength="50" required/>
            </td>

        </tr>

        <!----- Submit and Reset ------------------------------------------------->
        
    </table>
    
    <div class="btns">
        <button class="btnSubmit blue" name="button" value="ok">OK</button>
        <button class="btnSubmit blue" type="reset">Reset</button>
    </div>

</form>

</body>
</html>
