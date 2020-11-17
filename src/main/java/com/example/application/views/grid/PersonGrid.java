package com.example.application.views.grid;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.renderer.TemplateRenderer;

@CssImport(value = "./styles/components/grid/person-grid.css", themeFor = "vaadin-grid")
public class PersonGrid extends Grid<Person> {

    public PersonGrid() {
        super(Person.class);
        removeAllColumns();
        addColumn(TemplateRenderer.<Person>of("<vaadin-text-field id='[[item.id]]' on-change='onchanged' value='[[item.name]]' />")
                .withProperty("name", person -> person.getName())
                .withProperty("id", person -> person.hashCode())
                .withEventHandler("onchanged", person -> {
                    System.out.println("onchanged");
                    getElement()
                            .executeJs("return this.getRootNode().getElementById($0).value", person.hashCode())
                            .then(String.class, s -> {

                                System.out.println("person new name " + s);
                                //person.setName(s)
                            });
                })
            ).setHeader("Name");
        //addColumn("name");
        addColumn("email");
        setItems(new Person("Donald Duck", "donald.duck@gmail.com"),
                new Person("Mini Mouse", "mini.mouse@yahoo.com"),
                new Person("Goofy", "goofy@aol.com"),
                new Person("Pluto", "pluto@msn.com"),
                new Person("Mini Mouse", "mini.mouse@yahoo.com"),
                new Person("Goofy", "goofy@aol.com"),
                new Person("Pluto", "pluto@msn.com"),
                new Person("Micky Mouse", "micky.mouse@yahoo.com"),
                new Person("Micky Mouse", "micky.mouse@yahoo.com"),
                new Person("Micky Mouse", "micky.mouse@yahoo.com"));

        if (getDataProvider().size(new Query<>()) < 5)
            setHeightByRows(true);
        else
            setHeight("238px");

        setSizeFull();
    }
}
