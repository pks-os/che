/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.golang.ide.project;

import static org.eclipse.che.plugin.golang.ide.GolangExtension.GOLANG_CATEGORY;
import static org.eclipse.che.plugin.golang.shared.Constants.GOLANG_PROJECT_TYPE_ID;

import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;

/**
 * Provides information for registering Golang project type into project wizard.
 *
 * @author Eugene Ivantsov
 */
public class GolangProjectWizardRegistrar implements ProjectWizardRegistrar {

  private final List<Provider<? extends WizardPage<MutableProjectConfig>>> wizardPages;

  public GolangProjectWizardRegistrar() {
    wizardPages = new ArrayList<>();
  }

  @Override
  public String getProjectTypeId() {
    return GOLANG_PROJECT_TYPE_ID;
  }

  @Override
  public String getCategory() {
    return GOLANG_CATEGORY;
  }

  @Override
  public List<Provider<? extends WizardPage<MutableProjectConfig>>> getWizardPages() {
    return wizardPages;
  }
}
