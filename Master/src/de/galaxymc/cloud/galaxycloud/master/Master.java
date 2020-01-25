package de.galaxymc.cloud.galaxycloud.master;

import de.galaxymc.cloud.galaxycloud.library.CloudLibrary;
import de.galaxymc.cloud.galaxycloud.library.logger.Logger;
import de.galaxymc.cloud.galaxycloud.library.machine.MachineInformation;
import de.galaxymc.cloud.galaxycloud.library.network.server.CloudServer;
import de.galaxymc.cloud.galaxycloud.library.network.server.settings.CloudServerSettings;
import de.galaxymc.cloud.galaxycloud.library.security.SecurityMethod;
import de.galaxymc.cloud.galaxycloud.master.command.CommandHandler;
import de.galaxymc.cloud.galaxycloud.master.event.MasterListener;
import de.galaxymc.cloud.galaxycloud.master.file.GroupsFile;
import de.galaxymc.cloud.galaxycloud.master.file.SettingsFile;
import de.galaxymc.cloud.galaxycloud.master.group.GroupsManager;
import de.galaxymc.cloud.galaxycloud.master.settings.MasterSettings;

public class Master {

    private CommandHandler commandHandler;

    private SettingsFile settingsFile;
    private MasterSettings settings;

    private CloudServer server;
    private CloudServerSettings serverSettings;


    private SecurityMethod securityMethod;

    private GroupsManager groupsManager;
    private GroupsFile groupsFile;
    private Logger logger;

    public Master() {
        logger = new Logger("Master");
        Logger.logger.info("Startup...");
        logger.fatal("Fatal test output");
        logger.debug("Operating System: " + MachineInformation.operatingSystem);
        logger.debug("Cloud Version: " + CloudLibrary.VERSION);

        commandHandler = new CommandHandler();

        settingsFile = new SettingsFile();
        settingsFile.load();

        settings = settingsFile.getSettings();

        securityMethod = settings.getSecurityMethod();

        serverSettings = new CloudServerSettings(settings.getPort(), 10);
        server = new CloudServer(serverSettings);


        groupsFile = new GroupsFile();
        groupsFile.load();
        groupsManager = new GroupsManager();

    }

    public void init() {
        logger.info("                                                                                                                                                                                                                       \n" +
                "                                                                                                                                                                                                                       \n" +
                "        GGGGGGGGGGGGG                  lllllll                                                                       CCCCCCCCCCCCCLLLLLLLLLLL                  OOOOOOOOO     UUUUUUUU     UUUUUUUUDDDDDDDDDDDDD        \n" +
                "     GGG::::::::::::G                  l:::::l                                                                    CCC::::::::::::CL:::::::::L                OO:::::::::OO   U::::::U     U::::::UD::::::::::::DDD     \n" +
                "   GG:::::::::::::::G                  l:::::l                                                                  CC:::::::::::::::CL:::::::::L              OO:::::::::::::OO U::::::U     U::::::UD:::::::::::::::DD   \n" +
                "  G:::::GGGGGGGG::::G                  l:::::l                                                                 C:::::CCCCCCCC::::CLL:::::::LL             O:::::::OOO:::::::OUU:::::U     U:::::UUDDD:::::DDDDD:::::D  \n" +
                " G:::::G       GGGGGG  aaaaaaaaaaaaa    l::::l   aaaaaaaaaaaaa   xxxxxxx      xxxxxxxyyyyyyy           yyyyyyyC:::::C       CCCCCC  L:::::L               O::::::O   O::::::O U:::::U     U:::::U   D:::::D    D:::::D \n" +
                "G:::::G                a::::::::::::a   l::::l   a::::::::::::a   x:::::x    x:::::x  y:::::y         y:::::yC:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                "G:::::G                aaaaaaaaa:::::a  l::::l   aaaaaaaaa:::::a   x:::::x  x:::::x    y:::::y       y:::::y C:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                "G:::::G    GGGGGGGGGG           a::::a  l::::l            a::::a    x:::::xx:::::x      y:::::y     y:::::y  C:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                "G:::::G    G::::::::G    aaaaaaa:::::a  l::::l     aaaaaaa:::::a     x::::::::::x        y:::::y   y:::::y   C:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                "G:::::G    GGGGG::::G  aa::::::::::::a  l::::l   aa::::::::::::a      x::::::::x          y:::::y y:::::y    C:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                "G:::::G        G::::G a::::aaaa::::::a  l::::l  a::::aaaa::::::a      x::::::::x           y:::::y:::::y     C:::::C                L:::::L               O:::::O     O:::::O U:::::D     D:::::U   D:::::D     D:::::D\n" +
                " G:::::G       G::::Ga::::a    a:::::a  l::::l a::::a    a:::::a     x::::::::::x           y:::::::::y       C:::::C       CCCCCC  L:::::L         LLLLLLO::::::O   O::::::O U::::::U   U::::::U   D:::::D    D:::::D \n" +
                "  G:::::GGGGGGGG::::Ga::::a    a:::::a l::::::la::::a    a:::::a    x:::::xx:::::x           y:::::::y         C:::::CCCCCCCC::::CLL:::::::LLLLLLLLL:::::LO:::::::OOO:::::::O U:::::::UUU:::::::U DDD:::::DDDDD:::::D  \n" +
                "   GG:::::::::::::::Ga:::::aaaa::::::a l::::::la:::::aaaa::::::a   x:::::x  x:::::x           y:::::y           CC:::::::::::::::CL::::::::::::::::::::::L OO:::::::::::::OO   UU:::::::::::::UU  D:::::::::::::::DD   \n" +
                "     GGG::::::GGG:::G a::::::::::aa:::al::::::l a::::::::::aa:::a x:::::x    x:::::x         y:::::y              CCC::::::::::::CL::::::::::::::::::::::L   OO:::::::::OO       UU:::::::::UU    D::::::::::::DDD     \n" +
                "        GGGGGG   GGGG  aaaaaaaaaa  aaaallllllll  aaaaaaaaaa  aaaaxxxxxxx      xxxxxxx       y:::::y                  CCCCCCCCCCCCCLLLLLLLLLLLLLLLLLLLLLLLL     OOOOOOOOO           UUUUUUUUU      DDDDDDDDDDDDD        \n" +
                "                                                                                           y:::::y                                                                                                                     \n" +
                "                                                                                          y:::::y                                                                                                                      \n" +
                "                                                                                         y:::::y                                                                                                                       \n" +
                " Author: GalaxyLPS                                                                      y:::::y                                                                                                                        \n" +
                " Website: galaxycloud.de                                                              yyyyyyy                                                                                                                         \n" +
                "                                                                                                                                                                                                                       \n" +
                "Disclaimer: You are not allowed to share or edit GalaxyCloud(Master, Wrapper etc) in any way.\n\n");
        CloudLibrary.eventHandler.addEventListener(new MasterListener());
        commandHandler.listen();
        server.begin();
    }


    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public static Master instance;

    public static void main(String[] args) {
        instance = new Master();
        instance.init();
    }

    public void stop() {
        server.close();
    }

    public CloudServerSettings getServerSettings() {
        return serverSettings;
    }

    public SettingsFile getSettingsFile() {
        return settingsFile;
    }

    public MasterSettings getSettings() {
        return settings;
    }
}