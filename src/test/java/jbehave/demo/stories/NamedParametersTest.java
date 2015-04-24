package jbehave.demo.stories;

import jbehave.demo.BaseJBehaveRunner;
import jbehave.demo.steps.NamedParametersSteps;

public class NamedParametersTest extends BaseJBehaveRunner{
      @Override
      protected Object[] getSteps() {
        return new Object[]{new NamedParametersSteps()};
    }


}
