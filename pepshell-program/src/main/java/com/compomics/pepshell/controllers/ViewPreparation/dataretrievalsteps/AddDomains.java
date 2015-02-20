/*
 * Copyright 2014 Davy Maddelein.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.compomics.pepshell.controllers.ViewPreparation.dataretrievalsteps;

import com.compomics.pepshell.FaultBarrier;
import com.compomics.pepshell.ProgramVariables;
import com.compomics.pepshell.controllers.InfoFinders.DataRetrievalStep;
import com.compomics.pepshell.model.Protein;
import com.compomics.pepshell.model.UpdateMessage;
import com.compomics.pepshell.model.exceptions.DataRetrievalException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Davy Maddelein
 */
public class AddDomains extends DataRetrievalStep {

    private AddDomains(List<Protein> aProteinList) {
        this.proteinList = aProteinList;
    }

    public AddDomains() {
    }

    @Override
    public DataRetrievalStep getInstance(List<Protein> aProteinList) {
        return new AddDomains(aProteinList);
    }

    @Override
    public List<Protein> call() throws Exception {
        proteinList.stream().filter(protein -> protein.getDomains().size() == 0).forEach(protein -> {
            try {
                protein.addDomains(ProgramVariables.STRUCTUREDATASOURCE.getDomainData(protein));
                this.setChanged();
                this.notifyObservers(new UpdateMessage(true, "added domain info to " + protein.getProteinAccession(), false));
            } catch (DataRetrievalException ex) {
                FaultBarrier.getInstance().handleException(ex);
            }
        });
        return Collections.unmodifiableList(proteinList);
    }

    @Override
    public String getRetrievalStepDescription() {
        return "Add Domains";
    }
}
