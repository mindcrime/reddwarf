/*
 * Copyright 2008 Sun Microsystems, Inc.
 *
 * This file is part of the Darkstar Test Cluster
 *
 * Darkstar Test Cluster is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation and
 * distributed hereunder to you.
 *
 * Darkstar Test Cluster is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.projectdarkstar.tools.dtc.data;

import com.projectdarkstar.tools.dtc.service.DTCInvalidDataException;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a client application simulator
 * package to be run against a {@link ServerAppDTO} in a DTC test.
 */
public class ClientAppDTO extends AbstractDTO
{
    private Long id;
    private Long versionNumber;
    private String name;
    private String description;
    
    private List<ClientAppConfigDTO> configs;
    private PkgLibraryDTO requiredPkg;
    
    public ClientAppDTO(Long id,
                        Long versionNumber, 
                        String name,
                        String description)
    {
        this.setId(id);
        this.setVersionNumber(versionNumber);
        
        this.setName(name);
        this.setDescription(description);
        
        this.setConfigs(new ArrayList<ClientAppConfigDTO>());
        this.setRequiredPkg(null);
    }
    
    /**
     * Returns the id of the entity in persistent storage
     * 
     * @return id of the entity
     */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    /**
     * Returns the version number in the data store that this entity represents.
     * Whenever an update to an object is pushed to the persistent data
     * store, the version number is incremented.
     * 
     * @return version number of the entity
     */
    public Long getVersionNumber() { return versionNumber; }
    private void setVersionNumber(Long versionNumber) { this.versionNumber = versionNumber; }
    
    public String getName() { return name; }
    protected void setName(String name) { this.name = name; }
    public void updateName(String name)
            throws DTCInvalidDataException {
        this.updateAttribute("name", name);
    }
    
    public String getDescription() { return description; }
    protected void setDescription(String description) { this.description = description; }
    public void updateDescription(String description)
            throws DTCInvalidDataException {
        this.updateAttribute("description", description);
    }

    /**
     * Returns a list of client application configurations that can be used
     * to run this client application.
     * 
     * @return list of runtime configurations for this client app
     */
    public List<ClientAppConfigDTO> getConfigs() { return configs; }
    protected void setConfigs(List<ClientAppConfigDTO> configs) { this.configs = configs; }
    public void updateConfigs(List<ClientAppConfigDTO> configs)
            throws DTCInvalidDataException {
        this.updateAttribute("description", description);
    }
    
    /**
     * Returns the package library required to run this client application.
     * 
     * @return the package library required to run this client application.
     */
    public PkgLibraryDTO getRequiredPkg() { return requiredPkg; }
    protected void setRequiredPkg(PkgLibraryDTO requiredPkg) { this.requiredPkg = requiredPkg; }
    public void updateRequiredPkg(PkgLibraryDTO requiredPkg)
            throws DTCInvalidDataException {
        this.updateAttribute("requiredPkg", requiredPkg);
    }
    
    /** @inheritDoc */
    public void validate() throws DTCInvalidDataException {}
}
