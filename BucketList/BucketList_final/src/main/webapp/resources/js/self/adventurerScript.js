/**
 * 
 */
$(document).ready(function(){
		
		$("#idadventureName").keyup(function(event){
			//alert("1");
			var adventureName = $(this).val();
			checkAdventureNameViaAJAX(adventureName);
			
		});
		
          $("#mybucketList").css("display","block");
          $("#viewCompletedBucketList").css("display","block");
       
       $("#showBucketList").click(function(){    	  
    	   $("#mybucketList").css("display","block");
       });
       
       $("#viewBucketList").click(function(){
    	   $("#viewCompletedBucketList1").css("display","block");
       });
       
		
		
		$("button").click(function(){
			var name = $(this).attr("name");
			var adValue = $(this).val();
			var actionbutton = $(this);
			
			
			//alert(actionbutton);
			if(typeof name != "undefined"){
				if(name.indexOf("btnCompleted") >= 0){
					alert("!");
					$("input[name='adValButton']").val(name);
					$("input[name='adVal']").val(adValue);
				}
				else{
					alert("mast");
					$("input[name='adValButton']").val(name);
					$("input[name='adVal']").val(adValue);
					deleteFromBucketList();
				}
		   }
		});
       
	});

	
	function deleteFromBucketList(){
		
		alert("delete me ghussa");
		var buttonName = $("input[name='adValButton']").val();
		var adventureId = $("input[name='adVal']").val();
		
		$.ajax({
			
			type:"POST",
			url:"deleteAdventure",
			data: {adventureId : adventureId},
			success: function(result){
				alert("ajax me ghussa");
				if(result=="Y"){
					$("button[name="+buttonName+"]").parent().parent().remove();
				}
			},
			error:function(jqXHR){				
				alert("Problem occured while deleting records from BucketList" + jqXHR.status);
			}
		});
	}
		


	function submitBucketForm(){		
		alert("1");
		var buttonName = $("input[name='adValButton']").val();
		var adventureID = $("input[name='adVal']").val();
		var besttime = $("input[name='besttime']").val();
		var datecompleted = $("input[name='datecompleted']").val();
		var expectedexpense = $("input[name='expectedexpense']").val();
		var feedback = $("input[name='feedback']").val();
		var rating = $("input[name='rating']").val();
		var status = $("input[name='status']").val();
		var deleteButton = "btnDeleted";
		var num = buttonName.split("btnCompleted")[1];
		var btnDeleteButton = deleteButton.concat(num);
		
		
		$.ajax({
					
					type:"POST",
					url:"completedAdventure",
					data: {adventureID:adventureID ,besttime : besttime,datecompleted : datecompleted,expectedexpense:expectedexpense, feedback:feedback,rating:rating,status:status },
					success : function(result){
						if(result=="done"){
							alert("ghusa");
							$("#myModalBucketList").modal('toggle');
							$("button[name="+buttonName+"]").attr("disabled","disabled");
							$("button[name="+buttonName+"]").html('Completed');
							$("button[name="+btnDeleteButton+"]").attr("disabled","disabled");
						}
						
					},
					error: function(jqXHR){
						alert("Problem occured while completed adventure process" + jqXHR.status);
					}
					
				});
		
		
		
		
		
		return true;
		
	};

	
	function checkAdventureNameViaAJAX(adventureName){
		
		//alert("adventureName " + adventureName);
		$.ajax({
			
			type : "POST",
			url: "searchAdventure",
			data:  {adventureName : adventureName},
			success: function(result){
				if(result=="Y"){
					//alert(result);
					$("#errAdventureName").html("Adventure name already exists");
					$("#idadventureName").css('border-color',red);
					$("#btnSubmit").attr("disable",true)				
				}
				else{
					//alert(result);
					$("#errAdventureName").html("");
				    $("#idadventureName").css('border-color',black);
				    $("#btnSubmit").attr("disable",false);
				}
			},
			error: function(jqXHR){
				
				alert("Problem occured while checking the adventure name in AJAX function" + jqXHR.status);
				
			}

		});
	}
	
	
	
	
			