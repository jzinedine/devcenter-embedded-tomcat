package servlet;


import launch.Main;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "PlayServlet",
        urlPatterns = {"/"}
)
public class PlayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("AddAppUserCustomAlert  *************** STARTING");
        File folder = new File(Main.getProperties().getProperty("temp.path"));
        File result = new File(folder, "cam.m3u8");

        FFmpeg ffmpeg = new FFmpeg("ffmpeg");
        FFprobe ffprobe = new FFprobe("ffprobe");

        FFmpegBuilder builder =
                new FFmpegBuilder()
                        .setInput("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_175k.mov")
                        .addOutput(result.getAbsolutePath())
                        .addExtraArgs("-acodec", "copy")
                        .addExtraArgs("-vcodec", "copy")
                        .addExtraArgs("-f", "hls")
                        .addExtraArgs("-safe", "0")
                        .addExtraArgs("-hls_flags", "delete_segments+append_list")
                        .done();
        builder.setVerbosity(FFmpegBuilder.Verbosity.DEBUG);

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);

        // Run a one-pass encode
        executor.createJob(builder).run();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AddAppUserCustomAlert  *************** STARTING");
        System.out.println("AddAppUserCustomAlert  *************** STARTING");
        System.out.println("AddAppUserCustomAlert  *************** STARTING");
        resp.setContentType("application/json; charset=UTF-8");
        PrintWriter printout = resp.getWriter();
    }

    private String setError(String message) {
        String strMessage = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <title>Broadway Shows Price Alert</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no\" />\n" +
                "    <meta name=\"description\" content=\"Get Alerts when the price of your favorite shows increase or decrease\" />\n" +
                "    <link href=\"https://fonts.googleapis.com/css?family=Raleway:900,900italic,600,600italic,500,500italic%7CSource+Sans+Pro:300,300italic%7CQuattrocento+Sans:700,700italic\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                "    <link rel=\"icon\" type=\"image/png\" href=\"assets/images/favicon.png\" />\n" +
                "    <link rel=\"apple-touch-icon\" href=\"assets/images/apple-touch-icon.png\" />\n" +
                "    <link rel=\"stylesheet\" href=\"assets/main.css\" />\n" +
                "    <noscript><link rel=\"stylesheet\" href=\"assets/noscript.css\" /></noscript>\n" +
                "    <script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');ga('create', 'UA-109238947-1', 'auto');ga('set', 'anonymizeIp', true);</script>\n" +
                "</head>\n" +
                "<body class=\"is-loading\">\n" +
                "<div id=\"wrapper\">\n" +
                "    <div id=\"main\">\n" +
                "        <div class=\"inner\">\n" +
                "            <section id=\"home-section\">\n" +
                "                <h1 id=\"text04\">" + message + "</h1>\n" +
                "            </section>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<script src=\"assets/main.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        return strMessage;


    }
}
