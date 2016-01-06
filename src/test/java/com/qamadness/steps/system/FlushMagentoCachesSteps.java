package com.qamadness.steps.system;


import com.qamadness.pages.system.FlushMagentoCaches;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FlushMagentoCachesSteps extends ScenarioSteps{
    FlushMagentoCaches flushMagentoCaches;

    @Step
    public void click_flush_cache_btn(){ flushMagentoCaches.clickFlushCacheBtn();}

    @Step
    public void check_caches_flushed(String cachesSuccess) { flushMagentoCaches.checkCachesFlushed(cachesSuccess);}
}
