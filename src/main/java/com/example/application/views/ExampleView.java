package com.example.application.views;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;

@PageTitle("Example")
public class ExampleView extends Composite<Div> {

    public ExampleView() {
        getContent().add(new Span("Example view"));
    }
}
