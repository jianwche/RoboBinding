package org.robobinding.attribute;

import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

import org.robobinding.AttributeResolutionException;
import org.robobinding.GroupedAttributeResolutionException;

/**
 * 
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class ResolvedGroupAttributes {
    private Map<String, AbstractAttribute> resolvedChildAttributes = newHashMap();

    public ResolvedGroupAttributes(PendingGroupAttributes pendingGroupAttributes, ChildAttributeResolverMappings resolverMappings) {
	resolveChildAttributes(pendingGroupAttributes, resolverMappings);
    }

    private void resolveChildAttributes(PendingGroupAttributes pendingGroupAttributes, ChildAttributeResolverMappings resolverMappings) {
	GroupedAttributeResolutionException groupResolutionErrors = new GroupedAttributeResolutionException();
	for (Map.Entry<String, String> attributeEntry : pendingGroupAttributes.presentAttributes()) {
	    String attribute = attributeEntry.getKey();
	    ChildAttributeResolver resolver = resolverMappings.resolverFor(attribute);
	    try {
		AbstractAttribute childAttribute = resolver.resolveChildAttribute(attribute, attributeEntry.getValue());
		resolvedChildAttributes.put(attribute, childAttribute);
	    } catch (AttributeResolutionException e) {
		groupResolutionErrors.add(e);
	    }
	}

	groupResolutionErrors.assertNoErrors();
    }

    public ValueModelAttribute valueModelAttributeFor(String attributeName) {
	return attributeFor(attributeName);
    }

    public StaticResourceAttribute staticResourceAttributeFor(String attributeName) {
	return attributeFor(attributeName);
    }

    public <T extends Enum<T>> EnumAttribute<T> enumAttributeFor(String attributeName) {
	return attributeFor(attributeName);
    }

    public boolean hasAttribute(String attributeName) {
	return resolvedChildAttributes.containsKey(attributeName);
    }

    @SuppressWarnings("unchecked")
    public <AttributeType extends AbstractAttribute> AttributeType attributeFor(String attributeName) {
	return (AttributeType) resolvedChildAttributes.get(attributeName);
    }
}
