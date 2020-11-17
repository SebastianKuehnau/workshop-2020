package com.example.application.views.responsive;

import com.example.application.views.main.MainView;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaddon.CustomMediaQuery;

import java.util.HashSet;
import java.util.Set;

@PageTitle("Responsive View")
@Route(value = "responsive", layout = MainView.class)
public class ResponsiveView extends HorizontalLayout {

    private final FormLayout formLayout ;

    Set<TextField> textFieldSet = new HashSet<>();

    public ResponsiveView() {
        formLayout = new FormLayout();

        for (int i = 0; i < 10; i++) {

            TextField textField = new TextField("Input-" + i);
            formLayout.add(textField);
            textFieldSet.add(textField) ;
        }

        CustomMediaQuery customMediaQuery1000 = new CustomMediaQuery(this::removeCaption);
        customMediaQuery1000.setQuery("(min-width: 1000px)");

        add(customMediaQuery1000, formLayout);
    }

    private void removeCaption(Boolean setStyle) {
        formLayout.removeAll();
        if (setStyle) {
            textFieldSet.stream().forEach(textField -> formLayout.addFormItem(textField, "Form-Input"));
        } else {
            textFieldSet.stream().forEach(textField -> formLayout.add(textField));
        }
    }
}
