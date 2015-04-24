package jbehave.demo.stories;

import jbehave.demo.BaseJBehaveRunner;
import jbehave.demo.steps.ParametrisationByDelimitedNameSteps;
import org.jbehave.core.embedder.Embedder;


public class ParametrisationByDelimitedNameTest extends BaseJBehaveRunner {

    @Override
    protected Object[] getSteps() {
        return new Object[]{new ParametrisationByDelimitedNameSteps()};
    }

    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        embedder.embedderControls().doIgnoreFailureInView(true).doIgnoreFailureInStories(true).useThreads(1).useStoryTimeoutInSecs(600);
        return embedder;
    }
}
