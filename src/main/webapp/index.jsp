<html>
<head>
</head>
<body>
<link href="//vjs.zencdn.net/6.7/video-js.min.css" rel="stylesheet">
<script src="//vjs.zencdn.net/6.7/video.min.js"></script>
<script src="https://unpkg.com/@videojs/http-streaming@1.11.2/dist/videojs-http-streaming.js"></script>
<video-js id=vid1 width=600 height=300 class="vjs-default-skin" controls>
    <source
            src='/videos/cam.m3u8'
            type="application/x-mpegURL">
</video-js>
<script type="application/javascript">
    var player = videojs('vid1');
    player.play();
</script>

</body>
</html>