import os

# script para criar a estrutura de pastas e arquivos das listas de exercícios

for i in range(1, 11):
    folder_name = f"Exercicio{i:02d}"
    
    os.makedirs(folder_name, exist_ok=True)
    
    file_name = f"{folder_name}.java"
    
    file_path = os.path.join(folder_name, file_name)
    
    with open(file_path, 'w') as file:
        file.write(f"// Arquivo {file_name}\n")
        file.write(f"public class {folder_name} {{\n")
        file.write(f"    public static void main(String[] args) {{\n")
        file.write(f"        System.out.println(\"Este é o arquivo {file_name}\");\n")
        file.write("    }\n")
        file.write("}\n")