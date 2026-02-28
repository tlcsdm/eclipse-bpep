package com.tlcsdm.eclipse.bpep.resolver;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

public class Resolver {

	private static final ILog LOGGER = Platform.getLog(Resolver.class);

	public static String getName(final IField field) {
		return field.getElementName();
	}

	public static String getType(final IField field) {
		try {
			return Signature.toString(field.getTypeSignature());
		} catch (IllegalArgumentException | JavaModelException e) {
			LOGGER.error("Failed to resolve field type", e);
		}
		return null;
	}

	public static List<IField> findAllFields(final ICompilationUnit compilationUnit) {
		List<IField> fields = new ArrayList<>();
		try {
			IType clazz = compilationUnit.getTypes()[0];

			for (IField field : clazz.getFields()) {
				int flags = field.getFlags();
				if (!Flags.isStatic(flags)) {
					fields.add(field);
				}
			}

		} catch (JavaModelException e) {
			LOGGER.error("Failed to find fields in compilation unit", e);
		}
		return fields;
	}
}
