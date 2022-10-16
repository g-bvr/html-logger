package org.jkube.gitbeaver.htmllog.html;

public class HTMLConst {
	public final static String DOC_START 
	      = """
            <!DOCTYPE html>
            <html>
            <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <style>
            .collapsible {
              color: white;
              cursor: pointer;
              width: 100%;
              border: none;
              text-align: left;
              outline: none;
            }
            .level1 {
              padding: 18px;
              font-size: 18px;
            }
            .level2 {
              padding: 16px;
              font-size: 16px;
            }
            .level3 {
              padding: 14px;
              font-size: 14px;
            }
            .level4 {
              padding: 12px;
              font-size: 12px;
            }
            .level5 {
              padding: 10px;
              font-size: 10px;
            }
            .level6 {
              padding: 9px;
              font-size: 9px;
            }
            .normaltext {
              padding-right: 12px;
              font-size: 16px;
            }
            .console {
              font-family:'Courier New';
              padding: 10px;
              line-height: 125%;
              font-size: 14px;
              border: 5;
              background-color: black;
              color: white;
              margin-right: 24px
            }
            .active {
              color: yellow;
            }
            .colgreen {
              background-color: #009000;
            }
            .colgreen:hover {
              background-color: #00B000;
            }
            .colred {
              background-color: #A00000;
            }
            .colred:hover {
              background-color: #D00000;
            }
            .colblue {
              background-color: #0000B0;
            }
            .colblue:hover {
              background-color: #0000E0;
            }
            .colgray {
              background-color: #707070;
            }
            .colgray:hover {
              background-color: #909090;
            }
            .collapsible:after {
              content: '\\002B';
              color: white;
              font-weight: bold;
              float: right;
              margin-left: 5px;
            }
            
            .active:after {
              content: "\\2212";
            }
            .content {
              padding: 0 0 0 36px;
              max-height: 0;
              overflow: hidden;
              background-color: #e1e1e1;
            }
            </style>
            <title>""";
    public final static String HTML_START 
          = "</title>\n</head>\n<body>\n";
    public final static String HTML_END 
          = """	
            <script>
            var coll = document.getElementsByClassName("collapsible");
            var i;
            for (i = 0; i < coll.length; i++) {
              coll[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.maxHeight){
                  content.style.maxHeight = null;
                } else {
                  content.style.maxHeight = 1000000 + "px";
                }
              });
            }
            </script>
            </body>
            </html>""";
    
    public final static String SECTION_HEADER_START = "<button class=\"collapsible";
    public final static String SECTION_HEADER_MIDDLE = "\">";
    public final static String SECTION_HEADER_END = "</button>";
    public final static String SECTION_CONTENT_START = "<div class=\"content\">";
    public final static String SECTION_CONTENT_END = "</div>";
    public final static String PARAGRAPH_START = "<p class=\"normaltext\">";
    public final static String PARAGRAPH_END = "</p>";
    public final static String CONSOLE_START = "<div class=\"console\">";
    public final static String CONSOLE_END = "</div><br>";
    public final static String HEADER_START = "<h1>";
    public final static String HEADER_END = "</h1>";
    

}
