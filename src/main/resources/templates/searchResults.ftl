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
</style>
<body>
    <div class="maindiv">
        <#if authorBooks?has_content>
            <#list authorBooks as author, bookList>
                <div>
                   <h4>Books by ${author.name} ${author.surname}:</h4>
                </div>
                <#list bookList as book>
                    <div>
                        ${book.title}
                    </div>
                </#list>
            </#list>
        <#else>
            <h1>There is no books of this author!</h1>
        </#if>
    </div>
</body>
</html>
