package jbehave.demo.stories;

import jbehave.demo.BaseJBehaveRunner;
import jbehave.demo.steps.SimpleSteps;

public class SimpleTest extends BaseJBehaveRunner {

    @Override
    protected Object[] getSteps() {
        return new Object[]{new SimpleSteps()};
    }
}
