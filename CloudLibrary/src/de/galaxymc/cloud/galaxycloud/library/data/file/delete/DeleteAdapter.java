package de.galaxymc.cloud.galaxycloud.library.data.file.delete;

import de.galaxymc.cloud.galaxycloud.library.delete.Deletable;

public interface DeleteAdapter {

    public boolean delete(Deletable deletable, DeleteType deleteType);

}