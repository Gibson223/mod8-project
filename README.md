# MOD8-project

Welcome,

To properly use this new language, follow the steps below.

Open the "Final Project" folder where this REAMDE is also located, in an editor or IDE.
This IDE should preferrably IntelliJ Idea to (most easily) follow this guide.

Next, go to File -> Project Structure.
A new window will open.
Make sure that in the Project tab of that window, a Project SDK is set, as well as an output folder.
Then, on the left side of that same window, click Modules, and then Dependencies in the top right of that window.
Now click the + in on the right side of the window, then JARs or directories.
Then find and select the lib folder that is located in Final Project.
Then check antlr-runtime and hamcrest-core.
Click apply, OK and close the window.

Next, make sure the ANTLR plugin is installed and enabled.
This can be found in Settings -> Plugins, a new window will open.
If it is not installed yet, click Marketplace in the top part of the window and search for
"ANTLR v4 grammar plugin", click on it and click install.
Then enable it in the installed tab in the top of the window.
Click apply, OK and close the window.

Next, open the src/Grammar folder and then single click on Grammar.g4.
Now press Ctrl + Shift + G, a popup on the bottom right should tell you that grammar files were generated.

You should now be ready to run programs in this new language!

Open the src/RunLanguage/RunLanguage java class.
Now put the program you wrote in the PROGRAM_STRING string, at the marked place.
The only thing left to do is to click the triangle to the left of "public class RunLanguage {".
If your program does not work, the output will give a ParseException with onformation on where the mistake is.
Otherwise, the output will give you information on the executed program
and where the generated Hakell/SPROCKELL output is located if you may want to see that.

Have fun!
