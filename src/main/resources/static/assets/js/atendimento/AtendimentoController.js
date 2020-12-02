var AtendimentoController = new function() {
	
	this.list = function() {
		$('#atendimentosTableBody').empty();
		
		$.get( "/atendimentos", function( data ) {
			$.each(data, function(i, item) {
		        $('<tr>').append(
		            $('<td>').text(item.idAtendimento),
		            $('<td>').text(item.dataHora),
		            $('<td>').text(item.nomeProcedimento),
					$('<td>').text(item.paciente.idPaciente),
					$('<td>').text(item.medico.idMedico),
					$('<td class="actions"><a class="btn btn-warning btn-xs" onclick="AtendimentoController.edit('+item.idAtendimento+')">Editar</a><a class="btn btn-danger btn-xs" onclick="AtendimentoController.delete('+item.idAtendimento+')">Excluir</a></td>')
		        ).appendTo('#atendimentosTableBody');
		    });
		});
	}

	this.atendimentoList = function() {
		$('#atendimentoSelectList').empty();
		$.get( "/atendimentos", function( data ) {
			$.each(data, function(i, item) {
				$('<option value='+item.idAtendimento+'>'+item.nomeProcedimento+'</option>').appendTo('#atendimentoSelectList');
			});
		});
	}

	this.delete = function(idAtendimento) {
		$.ajax({
		    url: '/atendimentos/'+idAtendimento,
		    method: 'DELETE',
		    contentType: 'application/json',
		    success: function(result) {
		        AtendimentoController.list();
		    },
		    error: function(request,msg,error) {
		        alert('erro ao deletar');
		    }
		});
	}
	
	this.save = function() {
		var idAtendimentoToEdit = $("#idAtendimento").val();
		
		if (idAtendimentoToEdit == null || idAtendimentoToEdit == "") {
			var atendimento = this.getDadosAtendimentoModal();
			
			$.ajax({
			    url: '/atendimentos',
			    type: 'POST',
			    contentType: "application/json; charset=utf-8",
	    		dataType: "json",
				data: JSON.stringify(atendimento),
			    success: function() {
			        $("#idAtendimento").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.list();
					AtendimentoController.limparDadosAtendimentoModal();
			    },
			    error: function(request,msg,error) {
			       $("#idAtendimento").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.list();
					AtendimentoController.limparDadosAtendimentoModal();
			    }
			});
		}
		else {
			AtendimentoController.update(idAtendimentoToEdit);
		}
		
	}
	
	this.update = function(idAtendimento) {
		var atendimento = this.getDadosAtendimentoModal();
		
		$.ajax({
		    url: '/atendimentos/'+idAtendimento,
		    method: 'PUT',
		    contentType: "application/json; charset=utf-8",
    		dataType: "json",
			data: JSON.stringify(atendimento),
		    success: function(result) {
		        $("#idAtendimento").val("");
				$('#cadastrarAtendimento').modal('hide');
				AtendimentoController.list();
				AtendimentoController.limparDadosAtendimentoModal();
		    },
		    error: function(request,msg,error) {
		       $("#idAtendimento").val("");
			   $('#cadastrarAtendimento').modal('hide');
			   AtendimentoController.list();
			   AtendimentoController.limparDadosAtendimentoModal();
		    }
		});
	}
	
	this.edit = function(idAtendimento) {
		$("#idAtendimento").val(idAtendimento);
		
		$.get( "/atendimentos/" + idAtendimento, function( data ) {
			$('#cadastrarAtendimento').modal('show');
			AtendimentoController.setDadosAtendimentoModal(data);
		});
	}
	
	this.setDadosAtendimentoModal = function(atendimento) {
		$('#atendimentoDataHora').val(atendimento.dataHora),
		$('#atendimentoNomeProcedimento').val(atendimento.nomeProcedimento)
	}
	
	this.limparDadosAtendimentoModal = function() {
		$('#atendimentoDataHora').val(''),
		$('#atendimentoNomeProcedimento').val('')

	}
		
	this.getDadosAtendimentoModal = function() {
		var atendimento = {
			dataHora: $('#atendimentoDataHora').val(),
			nomeProcedimento: $('#atendimentoNomeProcedimento').val(),
			paciente: {
				idPaciente : $('#pacienteSelectList').val()
			},
			medico : {
				idMedico : $('#medicoSelectList').val()
			}
		}
		
		return atendimento;
	}
	
}
