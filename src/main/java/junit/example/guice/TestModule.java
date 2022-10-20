package junit.example.guice;

import com.google.inject.AbstractModule;

public final class TestModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SomeInterface.class).to(SomeImplementation.class);
    }

}

