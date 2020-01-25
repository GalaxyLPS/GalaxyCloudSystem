package de.galaxymc.cloud.galaxycloud.library.network.packet.response;

public enum PacketResponse {

    SUCCESS, UNKNOWN, TARGET_NOT_FOUND, OTHER;

    public static PacketResponse fromString(String s) {
        switch (s.toLowerCase()) {
            case "success":
                return SUCCESS;
            case "unknown":
                return UNKNOWN;
            case "target_not_found":
            case "targetnotfound":
            case "target not found":
            case "targetnot found":
            case "target notfound":
                return TARGET_NOT_FOUND;
            default:
                return OTHER;
        }
    }
}