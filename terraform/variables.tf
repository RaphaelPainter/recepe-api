# ---------------------------------------------------------------------------------------------------------------------
# VARIABLES
# ---------------------------------------------------------------------------------------------------------------------

variable "aws_region" {
  description = "The AWS region to create things in."
}

variable "aws_profile" {
  description = "AWS profile"
}

variable "stack" {
  description = "Name of the stack."
  default     = "apprunner-workshop"
}

variable "vpc_cidr" {
  description = "CIDR for the VPC"
  default     = "172.17.0.0/16"
}

variable "az_count" {
  description = "Number of AZs to cover in a given AWS region"
  default     = "2"
}

variable "aws_ecr" {
  description = "AWS ECR "
}

variable "family" {
  description = "Family of the Task Definition"
  default     = "recipe-api"
}

variable "container_port" {
  description = "Port exposed by the docker image to redirect traffic to"
  default     = 8080
}

variable "max_concurrency" {
  description = "AppRunner Instance MAX Concurrency"
  default     = 100
}

variable "max_size" {
  description = "AppRunner Instance MAX Size"
  default     = "2"
}

variable "min_size" {
  description = "AppRunner Instance MIN Size"
  default     = "1"
}


# Source repo name and branch

variable "source_repo_name" {
  description = "Source repo name"
  type        = string
}

variable "source_repo_branch" {
  description = "Source repo branch"
  type        = string
}


# Image repo name for ECR

variable "image_repo_name" {
  description = "Image repo name"
  type        = string
}

variable "image_identifier" {
  description = "image_identifier"
  type        = string
}

variable "apprunner-service-role" {
  description = "This role gives App Runner permission to access ECR"
  default     = "recipe-api"
}

variable "codebuild_cache_bucket_name" {
  description = "Bucketname to use for storing codebuild cache artifacts"
}
variable "codecommit_username" {
  description = "Codecommit user name for config and push orperation"
}
variable "codecommit_email" {
  description = "Codecommit email for git push orperation"
}
