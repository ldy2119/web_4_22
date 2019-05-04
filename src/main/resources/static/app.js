let loginStatus = null;

async function login() {

    let user = {
        account : "aaa",
        password : "1234"
    };

    try
    {
        loginStatus = await $.ajax({
            url : "/login",
            type : "POST",
            contentType : 'application/json',
            data : JSON.stringify(user)
        });
        if(loginStatus.data != null)
        {
            loginStatus = loginStatus.data;
            init();
        }
    }
    catch (e) {
        console.log(JSON.stringify(e));
    }
}

function init()
{
    $(".right").html
    (`
        <img src="/attachment/user/${loginStatus.id}"><br>
        아이디 : ${loginStatus.account}<br>
        이름 : ${loginStatus.name}<br>
        <br>
        가입일 : ${loginStatus.created}<br>
    `);
    getPost();
    getCurrentPost();
}

async function getCurrentPost()
{
    try
    {
        let response = await $.ajax({
            url : "/findCurrentPost/" + loginStatus.id,
            type : "GET"
        });

        if(response.data != null)
        {
            response = response.data;
            $("#content").html
            (`
                <h1 id = "title">${response.title}</h1>
                <div id = "name">${response.userName}</div>
                <div id = "created">${response.created}</div>
                <div id = "description">${response.content}</div>
                <div><button onclick="prevPost(${response.id})">이전</button><button onclick="openPostDialog(${response.id})">수정</button><button onclick="deletePost(${response.id})">삭제</button><button onclick="nextPost(${response.id})">다음</button></div>
            `);
        }

    }
    catch (e) {

    }
}

async function getPost() {
    try
    {
        let response = await $.ajax({
            url: "/listPost",
            type: "GET"
        });

        if(response.data != null)
        {
            $("#PostList").html("");
            response = response.data;
            for(let i = 0; i < response.length; i++)
            {
                $("#PostList").prepend
                (`
                   <li id = "${response[i].id}"><button onclick="readPost(${response[i].id})">${response[i].title}</button></li>
               `);
            }
        }
    }
    catch (e) {

    }
}

async function readPost(id) {
    try
    {
        let response = await $.ajax({
            url : "/findPost/" + id,
            type : "GET"
        });
        if(response.data != null)
        {
            response = response.data;
            $("#content").html
            (`
                <h1 id = "title">${response.title}</h1>
                <div id = "name">${response.userName}</div>
                <div id = "created">${response.created}</div>
                <div id = "description">${response.content}</div>
                <div><button onclick="prevPost(${response.id})">이전</button><button onclick="openPostDialog(${response.id})">수정</button><button onclick="deletePost(${response.id})">삭제</button><button onclick="nextPost(${response.id})">다음</button></div>
            `);
        }
    }
    catch (e) {
        
    }
}

let postId = null;
async function writePost()
{
    let title = $("#postTitle").val();
    let content = $("#postContent").val();
    // let file = $("#srcFile").val();

    let post = {
        title : title,
        content : content,
        userId : loginStatus.id
    };

    try
    {
        let response = null;
        if(postId == null)
        {
            response = await $.ajax({
                url : "/addPost",
                type : "POST",
                data : JSON.stringify(post),
                contentType : 'application/json'
            });

            if(response.data != null)
            {
                getPost();
                getCurrentPost();
            }

        }
        else
        {
            post.id = postId;
            response = await $.ajax({
                url : "/updatePost",
                type : "PUT",
                data : JSON.stringify(post),
                contentType : 'application/json'
            });

        }
        closePostDialog();


        if(response.data != null)
        {
            getPost();
            getCurrentPost();
        }
    }
    catch (e) {
        console.log(JSON.stringify(e));
    }
    postId = null;


}

async function deletePost(id)
{
    try
    {
        let response = await $.ajax({
            url : "/deletePost/" + id,
            type : "DELETE"
        });

        if(response.data != null)
        {
            getPost();
            getCurrentPost();
        }
    }
    catch (e) {

    }

}

async function prevPost(id)
{
    let e = $("#PostList").find("li#" + id);
    let f = $("#PostList").children();

    if(e.prev().length == 0)
    {
        readPost(f.eq(f.length - 1).attr("id"));
    }
    else
    {
        readPost(e.prev().attr("id"));
    }
}

async function nextPost(id)
{
    let e = $("#PostList").find("li#" + id);
    let f = $("#PostList").children();

    if(e.next().length == 0)
    {
        readPost(f.eq(0).attr("id"));
    }
    else
    {
        readPost(e.next().attr("id"));
    }
}

function openPostDialog(id)
{
    if(id != null)
    {
        let title = $("#title");
        let content = $("#description");
        postId = id;
        $("#postTitle").val(title.html());
        $("#postContent").val(content.html());

    }
    $("#commentContainer").show(400);
}

function closePostDialog()
{
    $("#srcFile").val("");
    $("#postContent").val("");
    $("#postTitle").val("");
    $("#commentContainer").hide(1000);
    postId = null;
}

$(document).ready(function () {
    login();
});