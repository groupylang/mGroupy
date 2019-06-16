toy : lexical_analysis.cpp \
		abstract_syntax_tree.cpp \
		syntax_analysis.cpp \
		code_generator.cpp \
		JIT_driver.cpp \
		toy.cpp
	clang++ -g -O3 \
		lexical_analysis.cpp \
		abstract_syntax_tree.cpp \
		syntax_analysis.cpp \
		code_generator.cpp \
		JIT_driver.cpp \
		toy.cpp \
		`llvm-config --cppflags --ldflags --libs core` \
		-o toy

.PHONY : clean
clean :
	rm -f *.o