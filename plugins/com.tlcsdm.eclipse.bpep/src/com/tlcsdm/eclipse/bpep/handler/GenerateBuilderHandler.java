package com.tlcsdm.eclipse.bpep.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.ui.IWorkingCopyManager;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.tlcsdm.eclipse.bpep.view.CreateDialog;

public class GenerateBuilderHandler extends AbstractHandler {

	private static final ILog LOGGER = Platform.getLog(GenerateBuilderHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor == null) {
			return null;
		}

		IWorkingCopyManager manager = JavaUI.getWorkingCopyManager();
		IEditorInput editorInput = editor.getEditorInput();
		try {
			manager.connect(editorInput);
			ICompilationUnit workingCopy = manager.getWorkingCopy(editorInput);

			Shell shell = HandlerUtil.getActiveShell(event);
			CreateDialog dialog = new CreateDialog(shell);
			dialog.show(workingCopy);

			synchronized (workingCopy) {
				workingCopy.reconcile(ICompilationUnit.NO_AST, false, null, null);
			}

		} catch (CoreException e) {
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error",
					"Failed to generate builder: " + e.getMessage());
			LOGGER.error("Failed to generate builder", e);
		} finally {
			manager.disconnect(editorInput);
		}
		return null;
	}
}
