package com.luxary_team.simpleweather.presenter.general;


import com.luxary_team.simpleweather.controller.DataComponent;
import com.luxary_team.simpleweather.ui.fragment.general.GeneralFragment;

import dagger.Component;

@GeneralScope
@Component(dependencies = DataComponent.class, modules = GeneralModule.class)
public interface GeneralComponent {
    void inject(GeneralFragment fragment);
}
