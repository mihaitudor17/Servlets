<%--
  Created by IntelliJ IDEA.
  User: Ritan
  Date: 10/15/2022
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        ol {
            list-style: none;
            padding: 0;
            margin: 0;
            counter-reset: list-counter;
            margin-bottom: 26px;
            margin-top: 18px;
        }
        li {
            padding: 0;
            position: relative;
            font-size: 16px;
            line-height: 24px;
            font-family: "adelle-sans",sans-serif;
            font-style: normal;
            font-weight: normal;
            color: #666;
        }
        ol li {
            position: relative;
            padding-left: 35px;
            min-height: 24px;
            margin-top: 14px;
        }
        ol li:before {
            content: counter(list-counter,decimal);
            counter-increment: list-counter;
            display: inline-block;

            position: absolute;
            top: 0;
            left: 0;
            width: 24px;
            height: 24px;
            text-align: center;
            line-height: 24px;
            font-family: "adelle-sans",sans-serif;
            font-style: normal;
            font-weight: 700;
            font-size: 14px;
            border-radius: 100%;
            color: #FFF;
            background: #88CE3D;
        }

        ul{
            /*list-style: url(https://i.imgur.com/iDST6Z1.png);*/
            list-style: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAQCAYAAAD52jQlAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6QjMyQjRFMTlGMkQzMTFFMjgzRTBCOUY2RkQ3RjE4MjkiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6QjMyQjRFMUFGMkQzMTFFMjgzRTBCOUY2RkQ3RjE4MjkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpCMzJCNEUxN0YyRDMxMUUyODNFMEI5RjZGRDdGMTgyOSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpCMzJCNEUxOEYyRDMxMUUyODNFMEI5RjZGRDdGMTgyOSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PhxCeqgAAADUSURBVHjaYpx5ZiYDhSAdiOuBmBOIW4C4l4VCA4uBuAeJD2IfZKLAwBI0A2FAj4kCA7uxiH8D4v1MVDTwFxCHAvF9JioaGATE20AcmKFSQGwDxFwUGLgVJgAyNAaIHwDxYSC+A8QGlBgIM7QfiFmhfEkg3o1mcCkpBoIAKJ1yo4mJAPEeIHYBYlcg7iLFQJhLJ2MRF4YGB8kGwgytAOI5WOR4yDEQZuh/IE7DYTDJBiInKUIGE20gsqH4DCbJQFjsM2Ax+CUQpwDxK2iS2klKtgMIMABAPTpYIwSEtAAAAABJRU5ErkJggg==);

        }
        ul li {
            line-height: 40px;
            margin-bottom: 5px;
            font-size: 18px;
            font-weight: normal;
        }</style>
</head>

<body>
<div>
    <div>
        <ol>
            <li>Token: ${requestScope.get("token")}</li>
            <li>Email: ${param.get("email")}</li>
            <li>Money spent: ${requestScope.get("sum")}</li>
            <li>Money after discount: ${requestScope.get("spent")}</li>
            <li>Level: ${requestScope.get("level")}</li>
            <li>Points: ${requestScope.get("points")}</li>
            <li style="visibility: ${requestScope.get("employed")}">Presents: ${requestScope.get("presents")}</li>
        </ol>
    </div>
</div>
</body>

</html>
