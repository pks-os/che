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
package org.eclipse.che.ide.ext.help.client.about;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.che.ide.ext.help.client.BuildInfo;
import org.eclipse.che.ide.ext.help.client.about.info.BuildDetailsPresenter;

/**
 * Presenter for displaying About Che information.
 *
 * @author Ann Shumilova
 */
@Singleton
public class AboutPresenter implements AboutView.ActionDelegate {
  private AboutView view;
  private BuildDetailsPresenter buildDetailsPresenter;
  private BuildInfo buildInfo;

  @Inject
  public AboutPresenter(
      AboutView view, BuildInfo buildInfo, BuildDetailsPresenter buildDetailsPresenter) {
    this.view = view;
    this.buildDetailsPresenter = buildDetailsPresenter;
    view.setDelegate(this);

    this.buildInfo = buildInfo;
  }

  public void showAbout() {
    view.showDialog();
    view.setVersion(buildInfo.version());
  }

  /** {@inheritDoc} */
  @Override
  public void onOkClicked() {
    view.close();
  }

  @Override
  public void onShowBuildDetailsClicked() {
    buildDetailsPresenter.showBuildDetails();
  }
}
