package com.tlcsdm.eclipse.bpep.generator;

import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;

public class MockGenerator implements Generator {

	private static final ILog LOGGER = Platform.getLog(MockGenerator.class);

	@Override
	public void generate(ICompilationUnit compilationUnit, List<IField> selectedFields) {
		try {
			LOGGER.info(compilationUnit.getSource());
		} catch (JavaModelException e) {
			LOGGER.error("Failed to get source from compilation unit", e);
		}
	}

}
