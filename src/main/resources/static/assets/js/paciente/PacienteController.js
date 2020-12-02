var PacienteController = new function() {
	
	this.list = function() {
		$('#pacientesTableBody').empty();
		
		$.get( "/pacientes", function( data ) {
			$.each(data, function(i, item) {
		        $('<tr>').append(
		            $('<td>').text(item.idPaciente),
		            $('<td>').text(item.nome),
		            $('<td>').text(item.nomeSocial),
					$('<td>').text(item.cpf),
					$('<td class="actions"><a class="btn btn-warning btn-xs" onclick="PacienteController.edit('+item.idPaciente+')">Editar</a><a class="btn btn-danger btn-xs" onclick="PacienteController.delete('+item.idPaciente+')">Excluir</a></td>')
		        ).appendTo('#pacientesTableBody');
		    });
		});
	}

	this.pacienteList = function() {
		$('#pacienteSelectList').empty();
		$.get( "/pacientes", function( data ) {
			$.each(data, function(i, item) {
				$('<option value='+item.idPaciente+'>'+item.nome+'</option>').appendTo('#pacienteSelectList');
				console.log(item);
			});
		});
	}
	
	this.delete = function(idPaciente) {
		$.ajax({
		    url: '/pacientes/'+idPaciente,
		    method: 'DELETE',
		    contentType: 'application/json',
		    success: function(result) {
		        PacienteController.list();
		    },
		    error: function(request,msg,error) {
		        alert('erro ao deletar');
		    }
		});
	}
	
	this.save = function() {
		var idPacienteToEdit = $("#pacienteId").val();
		
		if (idPacienteToEdit == null || idPacienteToEdit == "") {
			var paciente = this.getDadosPacienteModal();
			
			$.ajax({
			    url: '/pacientes',
			    type: 'POST',
			    contentType: "application/json; charset=utf-8",
	    		dataType: "json",
				data: JSON.stringify(paciente),
			    success: function() {
			        $("#pacienteId").val("");
					$('#cadastrarPaciente').modal('hide');
					PacienteController.list();
					PacienteController.limparDadosPacienteModal();
			    },
			    error: function(request,msg,error) {
			       $("#pacienteId").val("");
					$('#cadastrarPaciente').modal('hide');
					PacienteController.list();
					PacienteController.limparDadosPacienteModal();
			    }
			});
		}
		else {
			PacienteController.update(idPacienteToEdit);
		}
		
	}
	
	this.update = function(idPaciente) {
		var paciente = this.getDadosPacienteModal();
		
		$.ajax({
		    url: '/pacientes/'+idPaciente,
		    method: 'PUT',
		    contentType: "application/json; charset=utf-8",
    		dataType: "json",
			data: JSON.stringify(paciente),
		    success: function(result) {
		        $("#pacienteId").val("");
				$('#cadastrarPaciente').modal('hide');
				PacienteController.list();
				PacienteController.limparDadosPacienteModal();
		    },
		    error: function(request,msg,error) {
		       $("#pacienteId").val("");
			   $('#cadastrarPaciente').modal('hide');
			   PacienteController.list();
			   PacienteController.limparDadosPacienteModal();
		    }
		});
	}
	
	this.edit = function(idPaciente) {
		$("#pacienteId").val(idPaciente);
		
		$.get( "/pacientes/" + idPaciente, function( data ) {
			$('#cadastrarPaciente').modal('show');
			PacienteController.setDadosPacienteModal(data);
		});
	}
	
	this.setDadosPacienteModal = function(paciente) {
		$('#pacienteNome').val(paciente.nome),
		$('#pacienteNomeSocial').val(paciente.nomeSocial),
		$('#pacienteCpf').val(paciente.cpf)
	}
	
	this.limparDadosPacienteModal = function() {
		$('#pacienteNome').val(''),
		$('#pacienteNomeSocial').val(''),
		$('#pacienteCpf').val('')
	}
		
	this.getDadosPacienteModal = function() {
		var paciente = {
			nome: $('#pacienteNome').val(),
			nomeSocial: $('#pacienteNomeSocial').val(),
			cpf: $('#pacienteCpf').val(),
		}
		
		return paciente;
	}
	
}
