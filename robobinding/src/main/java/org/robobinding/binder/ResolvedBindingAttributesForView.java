package org.robobinding.binder;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.robobinding.BindingContext;
import org.robobinding.viewattribute.AttributeBindingException;
import org.robobinding.viewattribute.AttributeGroupBindingException;
import org.robobinding.viewattribute.ViewAttribute;

import android.view.View;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 * @author Cheng Wei
 */
public class ResolvedBindingAttributesForView {
    private View view;
    private final List<ViewAttribute> viewAttributes;

    ResolvedBindingAttributesForView(View view, Collection<ViewAttribute> viewAttributes) {
	this.view = view;
	this.viewAttributes = newArrayList(viewAttributes);
    }

    public ViewBindingErrors bindTo(BindingContext bindingContext) {
	ViewBindingErrors viewBindingError = new ViewBindingErrors(view);
	for (ViewAttribute viewAttribute : viewAttributes) {
	    try {
		viewAttribute.bindTo(bindingContext);
	    } catch (AttributeBindingException e) {
		viewBindingError.addAttributeError(e);
	    } catch (AttributeGroupBindingException e) {
		viewBindingError.addAttributeGroupError(e);
	    }
	}

	return viewBindingError;
    }

    public void preinitializeView(BindingContext bindingContext) {
	for (ViewAttribute viewAttribute : viewAttributes) {
	    viewAttribute.preInitializeView(bindingContext);
	}
    }
}