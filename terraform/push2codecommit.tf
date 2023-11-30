#data "aws_caller_identity" "current" {}
resource "null_resource" "push_recipe-apicode" {
  provisioner "local-exec" {
    command = <<EOT
	cd ../
	git config --global --unset credential.helper
	git config --system --unset credential.helper
#	git config --global user.name "Imtranur Rahman"
	git config --global user.name ${var.codecommit_username}
	git config --global user.email ${var.codecommit_email}
#	git config --global user.email imtranur@amazon.com
	git push -u origin develop2
      EOT
    interpreter = ["/bin/bash", "-c"]
    working_dir = path.module
  }
depends_on = [aws_codecommit_repository.source_repo]
}