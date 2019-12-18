package de.galaxymc.cloud.galaxycloud.master.settings;

import de.galaxymc.cloud.galaxycloud.library.security.SecurityMethod;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.modification.MinecraftModificationType;
import de.galaxymc.cloud.galaxycloud.library.server.minecraft.version.Version;
import de.galaxymc.cloud.galaxycloud.library.server.operator.Operator;

import java.util.ArrayList;

public class MasterSettings {

    private int port;
    private int webPort;
    private boolean useOperator;
    private ArrayList<Operator> operators;
    private SecurityMethod securityMethod;
    private MinecraftModificationType modificationType;
    private Version version;

    public MasterSettings(int port, int webPort, boolean useOperator, ArrayList<Operator> operators, SecurityMethod securityMethod, MinecraftModificationType modificationType, Version version) {
        this.port = port;
        this.webPort = webPort;
        this.useOperator = useOperator;
        this.operators = operators;
        this.securityMethod = securityMethod;
        this.modificationType = modificationType;
        this.version = version;
    }

    public ArrayList<Operator> getOperators() {
        return operators;
    }

    public int getPort() {
        return port;
    }

    public int getWebPort() {
        return webPort;
    }
}