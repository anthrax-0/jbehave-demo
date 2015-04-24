package jbehave.demo;

import de.codecentric.jbehave.junit.monitoring.*;
import org.jbehave.core.configuration.*;
import org.jbehave.core.embedder.*;
import org.jbehave.core.io.*;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.*;
import org.junit.runner.*;

import java.util.Properties;

import static org.jbehave.core.reporters.Format.*;


@RunWith(JUnitReportingRunner.class)
public abstract class BaseJBehaveRunner extends JUnitStory {

    private final CrossReference xref = new CrossReference();


    public Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(createStoryLoader())
                .useStoryReporterBuilder(createStoryReporter())
                .useStoryPathResolver(createStoryPathResolver())
                .useParameterConverters(createParameterConverters());
    }

    protected StoryLoader createStoryLoader() {
        return new LoadFromClasspath(this.getClass());
    }

    protected StoryPathResolver createStoryPathResolver() {
        return new UnderscoredCamelCaseResolver().removeFromClassName("Test");
    }

    protected ParameterConverters createParameterConverters() {
        return new ParameterConverters().addConverters(new ParameterConverters.EnumConverter());
    }

    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();
        JUnitReportingRunner.recommandedControls(embedder);
        return embedder;
    }

    private StoryReporterBuilder createStoryReporter() {
        return new StoryReporterBuilder().withFormats(HTML, STATS, CONSOLE).withCrossReference(xref).withFailureTrace(true);
    }




    public InjectableStepsFactory stepsFactory() {
        Object[] steps = getSteps();
        return new InstanceStepsFactory(configuration(), steps);
    }

    protected abstract Object[] getSteps();


}
