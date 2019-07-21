<#ftl encoding='UTF-8'>
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
    <div class="maindiv">
        <form method="post" action="/">

        <table align="center">
            <th>Search Book:</th>
            <td>Author First Name: <input type="text" name="authorName"></td>
            <td>Author Last Name: <input type="text" name="authorSurname"></td>
            <td><button type="submit" name="button" value="search">Search</button></td>

        </table>

            <h3>List of Available Books</h3>
        <#if books?has_content>
            <#list books as book>
                <div>
                    <a href="/bookInfo?bookId=${book.id}">${book.title}</a>
                </div>
            </#list>
        <#else>
            <h1>There are no books!</h1>
        </#if>

            <div class="btns"><button type="submit" name="button" value="add">Add Book</button>
            </div>
        </form>
    </div>
</body>
</html>
